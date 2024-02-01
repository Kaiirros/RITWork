<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset=utf-8" />
	<title>Clean input</title>
 	<style type="text/css">
 		form div{margin: 1em;}
 		form div label{float: left;width: 10%;}
 		form div.radio {float: left;}
 		.clearfix {clear: both;}
 	</style>
</head>
<body>
	<form action = "<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
		<div>
			<label>First Name:</label>
			<input type="text" name="fname" size="30" />
		</div>
		<div>
			<label>Date:</label>
			<input type="text" name="date" size="30" />
		</div>
		<div>
			<label>Email:</label>
			<input type="text" name="email" size="30" />
		</div>
		<div class="clearfix">
			<input type="reset" value="Reset Form" />
			<input type="submit" name="submit" value="Submit Form" />
		</div>	
	</form>
	<?php

	?>
</body>
</html>