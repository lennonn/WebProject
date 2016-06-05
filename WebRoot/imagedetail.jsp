<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery制作图片缩放</title>

<link rel="shortcut icon" type="image/zoom/ico"
	href="images/zoom/favicon.gif" />

<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/lightbox.css" type="text/css"
	media="screen" />

</head>
<body>

	<div class="imageRow">
		<div class="set">
			<div class="single first">
				<a href="images/zoom/examples/image-3.jpg" rel="lightbox[plants]"
					title="Click on the right side of the image to move forward."><img
					src="images/zoom/examples/thumb-3.jpg"
					alt="Plants: image 1 0f 4 thumb" />
				</a>
			</div>
			<div class="single">
				<a href="images/zoom/examples/image-4.jpg" rel="lightbox[plants]"
					title="Alternately you can press the right arrow key."><img
					src="images/zoom/examples/thumb-4.jpg"
					alt="Plants: image 2 0f 4 thumb" />
				</a>
			</div>
			<div class="single">
				<a href="images/zoom/examples/image-5.jpg" rel="lightbox[plants]"
					title="The script preloads the next image in the set as you're viewing."><img
					src="images/zoom/examples/thumb-5.jpg"
					alt="Plants: image 3 0f 4 thumb" />
				</a>
			</div>
			<div class="single last">
				<a href="images/zoom/examples/image-6.jpg" rel="lightbox[plants]"
					title="Click the X or anywhere outside the image to close"><img
					src="images/zoom/examples/thumb-6.jpg"
					alt="Plants: image 4 0f 4 thumb" />
				</a>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-zoom.min.js"></script>
	<script type="text/javascript" src="js/lightbox.js"></script>

</body>
</html>

