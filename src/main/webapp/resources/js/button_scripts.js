function create_file() {
    var ref = $('#jstree').jstree(true),
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

function create_folder() {
    var ref = $('#jstree').jstree(true),
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

function rename_element() {
    var ref = $('#jstree').jstree(true),
        sel = ref.get_selected();
    if (!sel.length) {
        return false;
    }
    sel = sel[0];
    ref.edit(sel);
}

function delete_element() {
    var ref = $('#jstree').jstree(true),
        sel = ref.get_selected();
    if (!sel.length) {
        return false;
    }
    ref.delete_node(sel);
}

function expand_all() {
    $("#jstree").jstree("open_all");
}

function collapse_all() {
    $("#jstree").jstree("close_all");
}