/**
 * 
 */

/** ********* Icon add / remove / toggle code *************** */

// image deletion function
var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='Recycle this image' class='ui-icon ui-icon-refresh'>Recycle image</a>";
function deleteImage($item) {
	$item.fadeOut(function() {
		var $list = $("ul", $trash).length ? $("ul", $trash) : $(
				"<ul class='gallery ui-helper-reset'/>").appendTo($trash);

		$item.find("a.ui-icon-trash").remove();
		$item.append(recycle_icon).appendTo($list).fadeIn(function() {
			$item.animate({
				color : "green"
			}).find("img").animate({
				background : "#ddd"
			});
		});
	});
}

// image recycle function
var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='Delete this image' class='ui-icon ui-icon-trash'>Delete image</a>";
function recycleImage($item) {
	$item.fadeOut(function() {
		$item.find("a.ui-icon-refresh").remove().end().css("color", "#222")
				.append(trash_icon).find("img").css("background", "#ddd").end()
				.appendTo($gallery).fadeIn();
	});
}