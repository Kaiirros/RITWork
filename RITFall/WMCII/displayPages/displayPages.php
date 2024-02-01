<?php
include("dbCon.php");

$sql = "SELECT * FROM `240Pages` LIMIT 50";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    //echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
    echo $row['page'] . "<br>" . $row['content'] . "<hr>";
  }
} else {
  echo "0 results";
}
$conn->close();
?>