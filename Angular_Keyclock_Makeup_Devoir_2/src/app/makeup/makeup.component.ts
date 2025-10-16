import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Makeup } from '../model/makeup.model';
import { MakeupService } from '../services/makeup.service';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-makeup',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './makeup.component.html',
  styleUrl: './makeup.component.css'
})
export class MakeupComponent implements OnInit {
  makeupProducts: Makeup[]; 

  constructor(private makeupService: MakeupService) {
    this.makeupProducts=[];
  
  }

  ngOnInit(): void {
    this.chargerMakeup();
   
  }
  
  chargerMakeup(){
     this.makeupService.listeMakeup().subscribe(mk => {
      console.log(mk);
      this.makeupProducts = mk;
    });
  }


 
  supprimerMakeup(m: Makeup) {
    let conf = confirm("Êtes-vous sûr de vouloir supprimer ce produit Makeup ?");
    if (conf) {
      this.makeupService.supprimerMakeup(m.idMakeup!).subscribe(()=>{
      console.log("makeup a été supprimé");
        this.chargerMakeup();
      });
    }
  }
  
}  