import { Component, OnInit } from '@angular/core';

import { Usuario } from 'src/app/Models/Usuario/usuario';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  usuario: Usuario = new Usuario();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){};

}
