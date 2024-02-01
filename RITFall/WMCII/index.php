<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        echo "Hello World" . "<br>";
        $favColor = "red";
        $isloggedin = true;
        echo $_SERVER['REMOTE_ADDR'] . "<br>";

        if($isloggedin){
            echo "logged in";
        ?>
        <strong>Hello again</strong>

        <?php
        } else {
            echo "not logged in";
        }

        var_dump($_SERVER);
    ?>
    <h1> <?php echo $favColor; ?></h1>
    
</body>
</html>