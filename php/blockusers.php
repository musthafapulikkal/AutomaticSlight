<?php
include("connection.php");
$consumerno=$_POST['consumerno'];
$sql="update tbl_register set status='2' where consumer_no='$consumerno'";
$result=mysqli_query($connect,$sql);
if ($result) {
	echo "success";
}
else
{
	echo "failed";
}
?>