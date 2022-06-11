import { Credenciales } from './../../../../Models/Usuario/credenciales';
import { UserServiceService } from './../../../../Service/Usuario/user-service.service';
import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  credenciales:Credenciales = new Credenciales();

  constructor(private router:Router, private route:ActivatedRoute, private servicio:UserServiceService) { }

  ngOnInit(): void {
  }

  iniciarSesion(){
    this.verificacion();
  };

  verificacion(){

      this.servicio.obtenerCredenciales(this.credenciales).subscribe(dato => {
        console.log(dato);
        this.irALaListaDeUsuario();
      });
  }



  irALaListaDeUsuario(){
    this.router.navigate(['lista-usuarios']);
  }

}
