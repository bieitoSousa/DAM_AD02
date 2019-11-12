package app.AD02;
public class Compañia {
 String name = "Franquicia bieito";
 String [][] productos ={    
    { "a1", "11" },
    { "a2", "12" },
    { "a3", "13" },
    { "a4", "14" },
    { "a5", "15" },
    { "a6", "16" },
    { "a7", "17" },
    { "a8", "18" },
    { "a9", "19" },
    { "b1", "21" },
    { "b2", "22" },
    { "b3", "23" },
    { "b4", "24" },
    { "b5", "25" },
    { "b6", "26" },
    { "b7", "27" },
    { "b8", "28" },
    { "b9", "29" }
};
 int getPrecioProduct(String idProducto){
     int precio = -1;
    for (int i = 0; i < this.productos.length; i++){
       if(idProducto.equals( this.productos[i][0])){
            precio = Integer.parseInt(this.productos[0][i]);
       } 
    }  
    return precio;
}
boolean productExist(String idProducto){
    for (int i = 0; i < this.productos.length; i++){
        if(idProducto.equals( this.productos[i][0])){
             return true;
        }  
    }
    return false;
}

}