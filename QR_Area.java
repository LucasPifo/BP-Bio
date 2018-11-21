foreach(DBForm('Areas')->WHERE('Bandera','=','1')->get() AS $stockRow){
$stockRow['QRArea']=cambiarcaracter($stockRow['Area']);
save($stockRow);
}
function cambiarcaracter($s){
    $s = str_replace("ñ","n",$s);
	$s = str_replace("Ñ","N",$s);
	$s = str_replace("á","a",$s);
	$s = str_replace("é","e",$s);
	$s = str_replace("í","i",$s);
	$s = str_replace("ó","o",$s);
	$s = str_replace("ú","u",$s);
	$s = str_replace("Á","A",$s);
	$s = str_replace("É","E",$s);
	$s = str_replace("Í","I",$s);
	$s = str_replace("Ó","O",$s);
	$s = str_replace("Ú","U",$s);
	return $s;
}