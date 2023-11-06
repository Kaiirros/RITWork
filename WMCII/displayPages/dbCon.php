<?php
$servername = "localhost";
$username = "dgm6546";
$password = "Satisfied7^disorientation";
$dbname = "dgm6546";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
?>