/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
    config.language="ko";
    config.enterMode=CKEDITOR.ENTER_BR;
    config.startupShowBorders=true;
    config.uiColor="#E7E7E7";
    config.width="950px";
    config.height="150px";
    config.skin="moonocolor";

    config.toolbar=[['Source','-','Preview'],
                    ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print'],
                    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
                    ['Undo','Redo'],
                    ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button'],
                    ['Image','Table','Smiley','SpecialChar'],
                    '/',
                    ['Styles','Format','Font','FontSize'],
                    ['Bold','Italic','Underline','Strike'],
                    ['TextColor','BGColor']];
    
    config.filebrowserUploadUrl = '/admin/addImage';
};
