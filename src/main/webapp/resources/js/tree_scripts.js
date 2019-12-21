$(function () {
    // 6 create an instance when the DOM is ready
    $('#jstree').jstree({
        "core": {
            expand_selected_onload: false,
            animation: 250,
            check_callback: true,
            force_text: true,
            themes: {"stripes": true},
            data: {
                type: 'GET',
                dataType: 'json',
                url: function (node) {
                    return (node.id === '#') ? 'get?id=root' : 'get?id=' + node.id;
                }
            }
        },
        "types": {
            "#": {
                "icon": "resources/images/icons/default_folder.png",
                "valid_children": ["folder_closed", "folder_opened", "file", "default"],
            },
            "folder_closed": {
                "icon": "resources/images/icons/default_folder.png",
                "valid_children": ["default", "file", "folder_closed", "folder_opened"]
            },
            "folder_opened": {
                "icon": "resources/images/icons/opened_folder.png",
                "valid_children": ["default", "file", "folder_closed", "folder_opened"]
            },
            "default": {
                "valid_children": ["default", "file"]
            },
            "file": {
                "icon": "resources/images/icons/file.png",
                "valid_children": []
            }
        },
        "plugins": [
            "contextmenu", "dnd", "search",
            "state", "types", "wholerow"
        ],
        "contextmenu": {//context menu actions
            "items": function () {
                return {
                    "Create File": {
                        "label": "Create File",
                        "action": function (data) {
                            var ref = $.jstree.reference(data.reference);
                            sel = ref.get_selected();
                            if (!sel.length) {
                                return false;
                            }
                            sel = sel[0];
                            sel = ref.create_node(sel, {"type": "file"});
                            if (sel) {
                                ref.edit(sel);
                            }
                        }
                    },
                    "Create Folder": {
                        "label": "Create Folder",
                        "action": function (data) {
                            var ref = $.jstree.reference(data.reference);
                            sel = ref.get_selected();
                            if (!sel.length) {
                                return false;
                            }
                            sel = sel[0];
                            sel = ref.create_node(sel, {"type": "folder_closed"});
                            if (sel) {
                                ref.edit(sel);
                            }
                        }
                    },
                    "Rename": {
                        "label": "Rename",
                        "action": function (data) {
                            var inst = $.jstree.reference(data.reference);
                            obj = inst.get_node(data.reference);
                            inst.edit(obj);
                        }
                    },
                    "Delete": {
                        "label": "Delete",
                        "action": function (data) {
                            var ref = $.jstree.reference(data.reference),
                                sel = ref.get_selected();
                            if (!sel.length) {
                                return false;
                            }
                            ref.delete_node(sel);
                        }
                    }
                };
            }
        }
    });
    /* Toggle between folder open and folder closed */
    $('#jstree').on('open_node.jstree', function (e, data) {
        data.instance.set_icon(data.node, "resources/images/icons/opened_folder.png")
    });
    $('#jstree').on('close_node.jstree', function (e, data) {
        data.instance.set_icon(data.node, "resources/images/icons/default_folder.png")
    });
    // bind to events triggered on the tree
    $('#jstree').on("changed.jstree", function (e, data) {
        console.log(data.selected);
    });
    //bind to update or create
    $('#jstree').on('rename_node.jstree', function renameCreateNode(nodeId, node) {
        var actionUrl = "rename?nodeId=" + node.node.id + "&nodeNewTitle=" + node.node.text + "&type=" + node.node.type + "&parent=" + node.node.parent;
        $.ajax({
            type: "POST",
            url: actionUrl,
            success: function () {
                $('#jstree').jstree(true).refresh_node(node.node.parent);
            }
        });
    });
    //bind to delete
    $('#jstree').on('delete_node.jstree', function deleteNode(nodeId, node) {
        var actionUrl = "delete?nodeId=" + node.node.id;
        $.ajax({
            type: "DELETE",
            url: actionUrl
        });
    });
    //bind to d'n'd
    $('#jstree').on('move_node.jstree', function dndNode(nodeId, node) {
        var actionUrl = "move?newParent=" + node.node.parent+"&nodeId="+node.node.id;
        $.ajax({
            type: "POST",
            url: actionUrl
        })
    });
});