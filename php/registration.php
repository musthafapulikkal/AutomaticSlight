<?php
include("connection.php");
$name=$_POST['username'];
$email=$_POST['email'];
$password=$_POST['password'];
$c_id=$_POST['consumerno'];
$q="select * from tbl_register where consumer_no='$c_id'";
$res=mysqli_query($connect,$q);
$check=mysqli_num_rows($res);
if($check>0)
{
 echo"invalid";
}
else
{
$sql="insert into tbl_register(username,email,password,consumer_no,status)values('$name','$email','$password','$c_id','0')";
$res=mysqli_query($connect,$sql);
if ($res==true) 
{
	echo $email;
}
else
{
echo "failed";
}
}


?>