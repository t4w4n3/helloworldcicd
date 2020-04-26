import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";

const routes: Routes = [
  {path: '', redirectTo: 'hello-world', pathMatch: 'full'},
  {path: 'hello-world', component: HelloWorldComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
