<?php




for ($k = 0; $k < 20; $k++) {
    $start_time = microtime(true);
    // Aquí va el fragmento de código a repetir

    $stdin = fopen('Matriz_2x2.txt', 'r');
    $anchAlt = explode(" ", "100 100");
    $alto = (int) $anchAlt[0];
    $ancho = (int) $anchAlt[1];
    $matriz = array();

    $i =0;
    while(!feof($stdin)) {
        
        $numeros = explode(" ", fgets($stdin));
        
        $fila = array();
        for ($j = 0; $j < count($numeros); $j++) {
            $fila[] = (int) $numeros[$j];
            if($i == 0 || $i % 2 == 0) {
                $fila[$j] += 1;
            }
            if($j == 0 || $j % 2 == 0){
                $fila[$j] += 2;
            }
            if($i % 2 != 0 && $j % 2 != 0){ 
                $fila[$j] -= 3;
            }
        }
        $matriz[] = $fila;

        $i++;

    }


    

    

    $var;
    for($i = 0; $i < $alto; $i++){
        for ($j = 0; $j < $ancho; $j++) {
            if($ancho-1 == $j){
                $var =  $matriz[$i][$j] . "\n";
            }else{
                $var = $matriz[$i][$j] . " ";
            }
        }
    }
   
fclose($stdin);


    // ...
    $end_time = microtime(true);
    $execution_time = ($end_time - $start_time);
    
    printf("%f\n", $execution_time * 1000000000);
}

  



  



?>