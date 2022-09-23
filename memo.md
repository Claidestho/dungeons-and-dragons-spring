# Mémo Spring boot

 ## Annotations 

* **@Controller** : Permet de spécifier que la classe est un controlleur classique 
* **@RestController** : Créer un controlleur de type REST, il automatise le formatage des réponses pour la lecture des données exposées
* **@Bean :** Permet de définir un composant, qui sera initialisé lors du run et pourra être utiliser au moment voulu
* **@Respository :** Spécifie que la classe contient toutes les opérations nécessaires au traitement des objets
* **@Column :** Permet de modifier les informations de chaque colonnes d'un modèle, et de préciser certaines limitations
* **@SpringBootApplication** : Permet l'utilisation de l'autoconfiguration de spring boot (@Configuration + @EnableAutoConfiguration + @ComponentScan ) 
* **@PUT / POST / GET / DELETE + Mapping** : Définition des différents end-points de l'application
* **@NotBlank / @NotNull :** Process de vérification des données reçues
* **@GeneratedValue :** Permet la génération de valeurs selon une stratégie donnée
* 