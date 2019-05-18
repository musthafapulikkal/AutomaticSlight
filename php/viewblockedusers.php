<?php
include "connection.php";
$query="select * from tbl_register where status='2'";
$result=mysqli_query($connect,$query);

while($row=mysqli_fetch_assoc($result))
{
 $data[]= array("consumerno"=>$row['consumer_no']);
}
echo json_encode($data);
?>