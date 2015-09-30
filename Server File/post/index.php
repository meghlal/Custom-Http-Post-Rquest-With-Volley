<?php

error_reporting(0);

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "android";

$conn = new mysqli($servername, $username, $password, $dbname);


$name=$_POST['name'];
$roll=$_POST['roll'];
$class=$_POST['class'];


$sql = "INSERT INTO `student` VALUES (null,'$name', '$roll', '$class')";

	if ($conn->query($sql) === TRUE) {
	

$response["devices"] = array();



        $device["id"] = 1;
        $device["type"] = "JSON";


        array_push($response["devices"], $device);  


    $response["success"] = true;
    echo json_encode($response);
	}


$conn->close();
