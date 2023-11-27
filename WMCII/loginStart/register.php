<?php

	function passMatch(){
		if(strcmp($_POST['pass'],$_POST['pass2'])==0){
			return true;
		}else{
			return false;
		}
	}s
	if (!empty($_POST['uname']) && !empty( $_POST['pass']) && !empty($_POST['pass2'])){
		if (passMatch()){	
			$uname = $_POST['uname'];
			$pass = $_POST['pass'];
			$pass2 = $_POST['pass2'];
			$hashpass = password_hash($pass, PASSWORD_DEFAULT);

			include("../dbCon.php");

			$sql = "INSERT INTO `240Login` (`uname`, `pass`) VALUES (?, ?);";

			$stmt = $conn->prepare($sql);

			$stmt->bind_param("ss", $uname, $hashpass);
			$stmt->execute();
			$stmt->close();

			header("Location: index.php");

		} else {
			die("Passwords do not match");
		}

	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset=utf-8" />
	<title>Register</title>
 	<style type="text/css">
 		form div{
 			margin: 1em;
 		}
 		form div label{
 			float: left;
 			width: 10%;
 		}
 		form div.radio{
 			float: left;
 		}
 		.clearfix{
 			clear: both;
 		}
 	</style>
</head>
<body>
	<form action = "<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
		<div>
			User Name:
			<input type="text" name="uname" size="30" />
		</div>
		<div>
			Password:
			<input type="password" name="pass" size="30" />
		</div>
		<div>
			Password (again):
			<input type="password" name="pass2" size="30" />
		</div>
		<div class="clearfix">
			<input type="reset" value="Reset Form" />
			<input type="submit" value="Submit Form" />
		</div>	
	</form>
</body>
</html>
