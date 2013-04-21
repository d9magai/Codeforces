<?php  
$array = explode(" ", file_get_contents('php://stdin') );
$val1 =(($array[0]/$array[2])+(($array[0]%$array[2])?1:0));
$val2 =(($array[1]/$array[2])+(($array[1]%$array[2])?1:0));

printf("%.0f", (integer)$val1*(integer)$val2);
?>