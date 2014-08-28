
package com.cjavaperu.jwd.sesion03.mb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.cjavaperu.jwd.sesion03.bean.Producto;


@ManagedBean
@ApplicationScoped
public class ProductoMB implements Serializable{

	
	private List<Producto> 	productos;	// Una coleccion de instancias new ArrayList<Producto>() ;	 
	private Producto 		producto;// Una instancia =		new Producto()

	public ProductoMB() {
		super();
		this.init();
	}

	private void init(){
		this.setProducto(new Producto());
		this.setProductos(new ArrayList<Producto>());
		this.defaultValues();
	}
	
	public ProductoMB(Producto producto) {
		super();
		this.producto = producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public String agregar(){
		
		if (this.getProducto().getId()==0) {
			this.getProducto().setId(this.getProductos().size()+1);
			this.getProductos().add(this.getProducto());			
			this.setProducto(new Producto());
			this.defaultValues();
		}
		
		return "producto_listado"; // Pagina a Redireccionar
						
	}

	public String modificar(Producto producto){
		this.setProducto(producto);		
		return "producto_registro"; // Pagina a Redireccionar
						
	}
	
	public String eliminar(Producto producto){
		this.getProductos().remove(producto);
		return "producto_listado"; // Pagina a Redireccionar						
	}
	

	/*************************************************************************
	 * Utilitarios
	 * 
	 */
	
	private void defaultValues(){
		
		//1ra Alternativa
		
		Producto prmProducto= new Producto();
		
		prmProducto.setId(0);
		prmProducto.setNombreCorto("JWD");
		prmProducto.setNombreLargo("Java Web Developer");
		prmProducto.setPrecio(1000D);
		prmProducto.setStockMinimo(5);
		prmProducto.setStockMaximo(50);
		prmProducto.setFechaRegistro(new Date());
		prmProducto.setObservaciones("Ninguna");
		
		this.setProducto(prmProducto);


		
		//2 da
		
		
		
	}
	
}
