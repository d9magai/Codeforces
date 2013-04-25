<?php

$fr = fopen("php://stdin", "r");
$n = fgets($fr);

for($i=0;$i<$n;$i++)
{
    $input = fgets($fr);

    if( preg_match('/R([0-9]+)C([0-9]+)/i', $input, $matches) )
    {   
        toStrY($matches);
    }   
    elseif( preg_match('/([A-Z]+)([0-9]+)/i', $input, $matches) )
    {   
        toRXCY($matches);
    }   
}

function toStrY($target)
{
    $col = $target[2];
    $str = ''; 

    while($col)
    {   
        $str = chr(65 + ($col-1)%26) . $str;
        $col = (integer)(($col - ($col-1)%26)/26);
    }   
    printf("%s%s\n", $str, $target[1]);
}

function toRXCY($target)
{
    $tar1 = $target[1];
    $len = strlen($tar1);
    $d = 1;
    $y = 0;

    for($j=$len-1;$j>=0;$j--)
    {   
        $y += (ord($tar1[$j])-64)*$d;
        $d*=26;
    }   
    printf("R%sC%s\n",$target[2],$y);
}

fclose($fr);
