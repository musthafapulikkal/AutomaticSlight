<?php
include "connection.php";
$query="select * from tbl_complaint";
$result=mysqli_query($connect,$query);

while($row=mysqli_fetch_assoc($result))
{
 $data[]= array("postid"=>$row['lid'],"complaint"=>$row['complaint']);
}
echo json_encode($data);
?>