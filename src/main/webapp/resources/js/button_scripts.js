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
    // var text = ref.get_node(sel);//!!! КОРРЕКТЫЙ ВИД ОБЪЕКТА!!!
    // $.ajax({
    //     type: 'post',
    //     url: "/webtree/",
    //     data: text,
    // });
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

function save_tree() {
    var v = $('#jstree').jstree(true).get_json('#', {no_li_attr:true});
    var mytext = JSON.stringify(v);


        var categoriesArray = new Array();
        var i = 0;
        $('#jstree li').each(function () {

            var id = $(this).attr('id').toString();
            if (id.indexOf("j") >= 0) {
                id = maxId + 1;
                $(this).attr('id', id);
                maxId = maxId + 1;
            }

            var text = $(this).find("a:first").text().trim();

            if ($(this).parent('ul.jstree-children')) {
                var parentId = $(this).parent('ul.jstree-children').parent('li').attr('id');
                var category = { id: id, name: text, parent: parent}

                categoriesArray.push(category);

                i++;
            }
        });

        $.ajax({
            type: 'post',
            url: "/webtree/",
            data: mytext,
        });
}