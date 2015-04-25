autoResizeTask();

$('.foo').resizable();
$('.foo').draggable();

var sidebarIcon = false;
var sidebarMaxWidth = 202;
var sidebarMinWidth = $('.start').width();

$('.sidebar').resizable({
	handles: 'e', 
	maxWidth: sidebarMaxWidth,
	minWidth: $('.start').width()
});

$('.sidebar').resize(function() {
	if ($('.sidebar').width() < sidebarMaxWidth) {
		$('.sidebar').css('width', $('.start').width());
		sidebarIcon = true;
		$('.sidebar').toggleClass('sidebar-view-icon');
	} else {
		$('.sidebar').css('width', sidebarMaxWidth);
		sidebarIcon = false;
	}

	if (sidebarIcon) {
		if (!$('.sidebar').hasClass('sidebar-icon-view')) {
			$('.sidebar').addClass('sidebar-icon-view');
		}
	} else {
		if ($('.sidebar').hasClass('sidebar-icon-view')) {
			$('.sidebar').removeClass('sidebar-icon-view');
		}
	}
});

function autoResize(attr, el, fixed, ref, width, less) {
	var size;
	var sizeRef;

	if (!width) {
		if ($('#home-holder').height() > $(window).height() && !fixed) {
			size = $('#home-holder').height();
		} else {
			size = $(window).height();
		}
	} else {

	}

	if (ref) {
		if ($.isNumeric(ref)) {
			sizeRef = ref;
		} else {
			sizeRef = $(ref).height();
		}
		
		if (!less) {
			$(el).css(attr, size - sizeRef);
		} else {
			$(el).css(attr, sizeRef);
		}
	} else {
		$(el).css(attr, size);
	}
}

function autoResizeTask() {
	ajustClock();
	resizeClock();
	autoResize("height", ".sidebar", true, '.maia');
	autoResize("maxHeight", ".main", false, '.maia');
	autoResize("padding-left", ".main", false, $('.sidebar').width(), true, true);
	//centerSidebar();
}

function ajustClock() {
	//time ajust
	var d = new Date();
	var time= ('0'	+ d.getHours()).slice(-2)+':'+('0' + d.getMinutes()).slice(-2);
	
	$('.clock-text').html(time);
}

function resizeClock() {
	//center ajust = (50% of window size) - (nav options size + right clock padding (25 + 21))
	var clockSize = (($('#home-holder').width() * .5) - $('.start').width() + (25 + $('.clock-text').width() * .5));

	$('.clock').css('width', clockSize);
};

function centerSidebar() {
	var sidebarSize = (($('body').height() * .5) - $('.start').height() - ($('.sidebar ul').height() * .5));
	$('.sidebar ul').css('margin-top', sidebarSize);
}

$(window).resize(function() {
	autoResizeTask();
});

$("#search").keyup(function() {
	if ($("#search").val() == '') {
		//$("body").css({backgroundColor:'#ffffff'}, 300);
		$("body").addClass('transition');
		$("body").removeClass('animated');
	} else {
		//$("body").css({backgroundColor:'#959595'}, 300);
		shortcut.add("esc",function() {
			$("#search").val("");
			this.remove("esc");
		});
		$("body").addClass('animated');
		$("body").removeClass('transition');
	}
});

var lock = false;

shortcut.add("alt+l",function() {
	if (!lock) {
		$('#locked').fadeIn();
		lock = true;
	} else {
		$('#locked').fadeOut();
		lock = false;
	}
});

//shortcut.add("F5",function() {});

window.setInterval(function(){
	ajustClock();
}, 1000);

$('.sidebar .item-icon').tooltip({
	animation: false,
	placement: 'right'
});