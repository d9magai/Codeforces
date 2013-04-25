<?php

class person {
    public $name;
    public $point;
}

$fr = fopen("php://stdin", "r");
$n = fgets($fr);
$list = array();
$names = array();

for($i=0;$i<$n;$i++)
{
    $data = fgets($fr);
    $array = explode(" ", $data);

    $list[$i] = new person;
    $list[$i]->name = $array[0];
    $list[$i]->point = $array[1];

    if(isset($names[$array[0]]))
        $names[$array[0]] = $names[$array[0]] + $array[1];
    else
        $names += array($array[0] => $array[1]);
}

$max=0;
foreach ($names as $key => $val) 
{
    if($max < $val)
        $max = $val;
}
unset($val);

$winner = array();
foreach ($list as &$val) 
{
    $str = $val->name;
    $pnt = $val->point;

    if(isset($winner[$str]))
        $winner[$str] = $winner[$str] + $pnt;
    else
        $winner += array($str => $pnt);

    if($winner[$str] >= $max && $names[$str] == $max)
    {
        echo $str;
        break;
    }

}
unset($val);
fclose($fr);
