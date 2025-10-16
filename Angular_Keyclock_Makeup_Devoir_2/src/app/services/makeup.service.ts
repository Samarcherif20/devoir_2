import { Injectable } from '@angular/core';
import { Makeup } from '../model/makeup.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MakeupService {
  private apiURL = 'http://localhost:8080/makeups/api';

  constructor(private http: HttpClient) {}

  // GET /makeups/api/all
  listeMakeup(): Observable<Makeup[]> {
    return this.http.get<Makeup[]>(`${this.apiURL}/all`);
  }

  // POST /makeups/api
  ajouterMakeup(makeup: Makeup): Observable<Makeup> {
    return this.http.post<Makeup>(this.apiURL, makeup);
  }

  // DELETE /makeups/api/{id}
  supprimerMakeup(id: number): Observable<void> {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete<void>(url);
  }

  // GET /makeups/api/{id}
  consulterMakeup(id: number): Observable<Makeup> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Makeup>(url);
  }

  // PUT /makeups/api
  updateMakeup(makeup: Makeup): Observable<Makeup> {
    return this.http.put<Makeup>(this.apiURL, makeup);
  }
}
