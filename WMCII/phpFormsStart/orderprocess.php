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
            $toppings = $_POST['pizzaToppings'];

            echo "Customer Name: " . $customerName . "<br>"; 
            echo "Customer ID: " . $customerID . "<br>"; 

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

            // Secondary Switch Statement for determining topping costs
            switch($toppings){
                case '0':
                    $toppingCost = 0;
                    $pizzaCost += $toppingCost;
                    break;
                case '1':
                    $toppingCost = 2.00;
                    $pizzaCost += $toppingCost;
                    break;
                case '2':
                    $toppingCost = 3.00;
                    $pizzaCost += $toppingCost;
                    break;
                case '3':
                    $toppingCost = 3.75;
                    $pizzaCost += $toppingCost;
                    break;
    
                default:
                    $pizzaCost += 0;
            }

            $taxAmount = $pizzaCost *.08;
            //Calculated new cost with topping included
            $total = $pizzaCost + $taxAmount + $toppingCost;
    
            $fmt = numfmt_create('en_US', NumberFormatter::CURRENCY);
            $pizzaCost = numfmt_format_currency($fmt, $pizzaCost, "USD");
            $taxAmount = numfmt_format_currency($fmt, $taxAmount, "USD");
            echo "Pizza Size: " . $pizzaType . "<br>";
            echo "Subtotal: " . $pizzaCost . "<br>";
            echo "Topping Price: " . $toppingCost . "<br>";
            echo "Tax: " . $taxAmount . "<br>";
            echo "Total: " . numfmt_format_currency($fmt, $total, "USD") . "<br>";
    
            echo "<h3> Thank you for your order, " . $customerName . "! </h3>" . "<br>";
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