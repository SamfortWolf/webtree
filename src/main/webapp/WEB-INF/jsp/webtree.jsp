<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>jsTree test</title>
    <!-- 2 load the theme CSS file -->
    <link rel="stylesheet" href="resources/dist/themes/default/style.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<h3>Web File Tree</h3>

<div class="btn-group" role="group" aria-label="...">
    <button type="button" class="btn btn-success btn-sm" onclick="create_file();">
        <span class="glyphicon glyphicon-file"></span>New File
    </button>
    <button type="button" class="btn btn-success btn-sm" onclick="create_folder();">
        <span class="glyphicon glyphicon-folder-close"></span> New Folder
    </button>
    <button type="button" class="btn btn-warning btn-sm" onclick="rename_element();">
        <span class="glyphicon glyphicon-pencil"></span> Rename
    </button>
    <button type="button" class="btn btn-danger btn-sm" onclick="delete_element();">
        <span class="glyphicon glyphicon-remove"></span> Delete
    </button>
    <button type="button" class="btn btn-info btn-sm" onclick="expand_all();">
        <span class="glyphicon glyphicon-collapse-down"></span> Expand All
    </button>
    <button type="button" class="btn btn-info btn-sm" onclick="collapse_all();">
        <span class="glyphicon glyphicon-collapse-up"></span> Collapse all
    </button>
</div>

<div id="jstree"></div>

<!-- include the jQuery library -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<!-- include the minified jstree source -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/js/tree_scripts.js"></script>
<script type="text/javascript" src="resources/js/button_scripts.js"></script>
</body>
</html>