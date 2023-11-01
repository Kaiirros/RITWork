<?php 
	$path = "./";
	$page = "Order Confirmation";
	include($path . "assets/inc/header.php");
?>

<div id="container">
    <?php

        if (!empty($_POST["customerID"]) && is_numeric($_POST["customerID"])){
            $customerName = $_POST["customerName"];
            $customerID = $_POST["customerID"];
            $pizzaSize = $_POST["pizzaSize"];   

            echo "Customer Name: " . $customerName . "<br>"; 
            echo "Customer ID: " . $customerID . "<br>"; 
            echo "Pizza Size: " . $pizzaSize . "<br>"; 

            switch($pizzaSize){
                case 'P':
                    $pizzaCost = 7.99;
                    $pizzaType = "Personal";
                    break;
                case 'S':
                    $pizzaCost = 10.99;
                    $pizzaType = "Small";
                    break;
                case 'M':
                    $pizzaCost = 13.99;
                    $pizzaType = "Medium";
                    break;
                case 'L':
                    $pizzaCost = 16.99;
                    $pizzaType = "Large";
                    break;
    
                default:
                    $pizzaCost = 13.99;
                    $pizzaType = "Medium";
            }
            $taxAmount = $pizzaCost *.08;
            $total = $pizzaCost + $taxAmount;
    
            $fmt = numfmt_create('en_US', NumberFormatter::CURRENCY);
            $pizzaCost = numfmt_format_currency($fmt, $pizzaCost, "USD");
            $taxAmount = numfmt_format_currency($fmt, $taxAmount, "USD");
            echo "Pizza Size: " . $pizzaType . "<br>";
            echo "Subtotal: " . $pizzaCost . "<br>";
            echo "Tax: " . $taxAmount . "<br>";
            echo "Total: " . numfmt_format_currency($fmt, $total, "USD") . "<br>";
    
            echo "Thank you for your order, " . $customerName . "!" . "<br>";
            echo "ID: " . $customerID;

        } else {
            header("Location: orderform.php");
            echo "Invalid ID";
        }


        



 
    ?>
</div>


<?php 
		include($path . "assets/inc/footer.php");
	?>