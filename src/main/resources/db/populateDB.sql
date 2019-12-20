DELETE FROM elements;

INSERT INTO ELEMENTS (parent, text, children, type) VALUES

    ('#',       'C:', true, 'folder_closed'),--100 000
    ('#',       'D:', true, 'folder_closed'),--100 001
    ('#',       'E:', true, 'folder_closed'),--100 002
    ('100000', 'Program Files', true, 'folder_closed'),
    ('100000', 'Users', true, 'folder_closed'),
    ('100000', 'Windows', true, 'folder_closed'),
    ('100003', 'Adobe', false, 'folder_closed'),
    ('100003', 'Java', false, 'folder_closed'),
    ('100003', 'JetBrains', false, 'folder_closed'),
    ('100004', 'Master', false, 'folder_closed'),
    ('100005', 'system32', false, 'folder_closed'),--100 010
    ('100001', 'Movies', true, 'folder_closed'),
    ('100001', 'Music', true, 'folder_closed'),
    ('100011', '2001: Space Oddity', true, 'folder_closed'),
    ('100011', 'Scarface', true, 'folder_closed'),
    ('100013', 'space_oddity.mkv', false, 'file'),
    ('100014', 'scarface.avi', false, 'file'),
    ('100012', 'Pink Floyd - The Dark Side Of the Moon.flac', false, 'file'),
    ('100002', 'Some Folder', true, 'folder_closed'),
    ('100018', 'Some File', false, 'file');--100 019
