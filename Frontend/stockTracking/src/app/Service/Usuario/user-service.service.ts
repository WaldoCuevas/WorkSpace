import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../../Models/Usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = "http://localhost:8080/api/usuarios";

  constructor(private httpClient: HttpClient) { }

  getListaUsuarios(): Observable<Usuario[]> {
    return this.httpClient.get<Usuario[]>(`${this.baseUrl}`);
  }

  registrarUsuario(usuario: Usuario): Observable<object> {
    return this.httpClient.post(`${this.baseUrl}`, usuario);
  }
}
