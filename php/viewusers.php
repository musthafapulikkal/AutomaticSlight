<?php
include "connection.php";
$query="select * from tbl_register where status='0'";
$result=mysqli_query($connect,$query);

while($row=mysqli_fetch_assoc($result))
{
 $data[]= array("email"=>$row['email'],"consumerno"=>$row['consumer_no'],"status"=>$row['status'],);
}
echo json_encode($data);
?>