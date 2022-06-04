import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//Import de Usuario
import { ListaUsuariosComponent } from './Component/Usuario/lista-usuarios/lista-usuarios.component';
import { RegistrarUsuarioComponent } from './Component/Usuario/registrar-usuario/registrar-usuario.component';

//Import de Producto
import { ListaProductoComponent } from './Component/Producto/lista-producto/lista-producto.component';
import { ModificarProductoComponent } from './Component/Producto/modificar-producto/modificar-producto.component';
import { RegistrarProductoComponent } from './Component/Producto/registrar-producto/registrar-producto.component';

const routes: Routes = [
  //Rutas para usuarios
  { path: 'usuarios', component: ListaUsuariosComponent },
  { path: 'u', redirectTo: 'usuarios', pathMatch: 'full' },
  { path: 'registrar-usuario', component: RegistrarUsuarioComponent },

  //rutas para productos
  { path: 'registrar-producto', component: RegistrarProductoComponent },
  { path: 'productos', component: ListaProductoComponent },
  { path: 'actualizar-producto/:id', component: ModificarProductoComponent },
  { path: 'p', redirectTo: 'productos', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
