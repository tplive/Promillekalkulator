# Promillekalkulator
Promillekalkulatoren beregner din promille.
Det gjør den ut i fra en standard formel som tar hensyn til kjønn og kroppsvekt.

https://www.fhi.no/historisk-arkiv/artikler/alkoholpromille---eksempler-pa-bere/
* 1 promille = 1 gram alkohol pr 1 kg blod.
* Alkoholen fordeler seg i 60% av kvinners kroppsvekt, 70% av menns.
* Alkohol forbrennes med 0,15 promille pr time. (0,1 - 0,25)
* For kvinner: Alkoholmengde i gram / (vekt i kg * 0,6) - (0,15 * timer fra drikkestart) = promille
* For menn: Alkoholmengde i gram / (vekt i kg * 0,7) - (0,15 * timer fra drikkestart) = promille
* Grov beregning. Kan bare brukes for å beregne alkoholkonsentrasjonen i blodet 1 time etter siste inntak.

https://www.fhi.no/ml/alkohologrusmidler/alkohol/alkohol-fakta/

Brukergrensesnitt:
Øverst: Promille nå (stor tekst, farget)
Slider: Antall timer siden inntak av alkoholen.
Innstillinger: 
* Bytt mellom mann/kvinne. 
* Tast inn vekt.
Enheter: Klikk på enhet for å legge den til inntak.
Tre knapper; Øl, Vin, Sprit (med mengde og alkoholprosent)
Appen beregner promille basert på hvor mange timer siden inntak.

Senere:
Beregne "real-time" promille.
Må ha tidspunkt for inntak av hver enhet. Regner rest-promille etter hver loop, tar utgangspunkt i tidspunktet for den første drinken. For å beregne hvor mye rest-promille er, må formelen trekke fra en andel rest-alkohol fra alle enheter samtidig, under antagelse at alle drinker forbrennes like fort..?
Når en enhet er helt ute av kroppen (0 gram rest) skal den fjernes fra listen.

Android UI design tutorial:
https://www.tutorialspoint.com/android/android_ui_design.htm
