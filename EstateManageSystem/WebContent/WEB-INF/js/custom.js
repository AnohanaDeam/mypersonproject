
$(document).on("click", "#checkMark", function(e) {
	iosOverlay({
		text: "Success!",
		duration: 2e3,
		icon: "../img/check.png"
	});
	return false;
});

$(document).on("click", "#cross", function(e) {
	iosOverlay({
		text: "Error!",
		duration: 2e3,
		icon: "../img/cross.png"
	});
	return false;
});
