import { Component, OnInit } from '@angular/core';

import { Usuario } from 'src/app/Models/Usuario/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  usuario: Usuario = new Usuario();
  email:String;
  password:String;

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.email = "Waldo@gmail.com";
    this.password = "123";
  }

  onSubmit(){
    this.verificacion();
  };

  verificacion(){

    if (this.usuario.email == this.email && this.usuario.password == this.password){
      console.log(this.email);
      console.log(this.password);
      this.irALaListaDeUsuario();
    } else {
      alert("datos invalidos, ingrese datos validos");
    }

  }

  irALaListaDeUsuario(){
    this.router.navigate(['lista-usuarios']);
  }

}
