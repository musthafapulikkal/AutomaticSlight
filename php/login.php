<?php
include("connection.php");
$email=$_POST['email'];
$password=$_POST['password'];
$sql="select email,password from tbl_register where email='$email' and password='$password' and status='1'";
$res=mysqli_query($connect,$sql);
while($row=mysqli_fetch_assoc($res))
{
echo $row["email"];

}

?>