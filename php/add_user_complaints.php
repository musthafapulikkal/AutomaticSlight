<?php
include("connection.php");
$email=$_POST['email'];
$postno=$_POST['postno'];
$complaint=$_POST['complaint'];
$sql="insert into tbl_user_complaints(user_email,post_no,complaint)values('$email','$postno','$complaint')";
$result=mysqli_query($connect,$sql);
if ($result) {
	echo "success";
}
else
{
	echo "failed";
}

?>