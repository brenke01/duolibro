import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HelloWorldComponent } from './helloWorld.component';
import { MaintextComponent } from './maintext/maintext.component';
import { SpanishtextComponent } from './spanishtext/spanishtext.component';

@NgModule({
  declarations: [
    HelloWorldComponent,
    MaintextComponent,
    SpanishtextComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [HelloWorldComponent, MaintextComponent, SpanishtextComponent]
})
export class HelloWorldModule { }
