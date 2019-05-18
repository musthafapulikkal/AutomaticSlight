<?php
include "connection.php";
$query="select * from tbl_user_complaints";
$result=mysqli_query($connect,$query);

while($row=mysqli_fetch_assoc($result))
{
 $data[]= array("email"=>$row['user_email'],"postno"=>$row['post_no'],"complaint"=>$row['complaint']);
}
echo json_encode($data);
?>