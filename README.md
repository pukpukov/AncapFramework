
# AncapLibrary
Фреймворк для баккит-разработки. Выполняет рутинные задачи

## Использование с помощью Maven

	 </repositories>
	     <repository>  
		     <id>AncapDatabase-mvn-repo</id>  
		     <url>https://raw.github.com/PukPukov/AncapDatabase/mvn-repo/</url>  
		     <snapshots> 
			     <enabled>true</enabled>  
			     <updatePolicy>always</updatePolicy>  
		     </snapshots>
	     </repository>
	     <repository>  
			 <id>AncapLibrary-mvn-repo</id>  
			 <url>https://raw.github.com/PukPukov/AncapLibrary/mvn-repo/</url>  
			 <snapshots>
				 <enabled>true</enabled>  
				 <updatePolicy>always</updatePolicy>  
			 </snapshots></repository>
     </repositories>
     
     <dependencies>  
		<dependency> 
			<groupId>org.spigotmc</groupId>  
			<artifactId>spigot-api</artifactId>  
			<version>1.16.5-R0.1-SNAPSHOT</version>  
			<scope>provided</scope>  
		</dependency>  
		<dependency> 
			<groupId>ru.pukpukov</groupId>  
			<artifactId>AncapLibrary</artifactId>  
			<version>1.0-SNAPSHOT.1</version>  
			<scope>provided</scope>  
		</dependency>  
		<dependency>
			<groupId>ru.pukpukov</groupId>  
			<artifactId>AncapDatabase</artifactId>  
			<version>alpha.1.0.1</version>  
			<scope>provided</scope>  
		</dependency>
		<dependency>  
			<groupId>ru.pukpukov</groupId>  
			<artifactId>AncapLibrary</artifactId>  
			<version>1.0-SNAPSHOT.1</version>  
			<scope>provided</scope>  
		</dependency>
     </dependencies>

## Использование

### Объявление мейн-класса плагина

    public class AncapAFB extends AncapPlugin {
    
    }

### Использование AncapLibrary EventAPI

    public class AncapStatesEventsListener implements Listener {  
      
		@EventHandler  
	    public void onWorldInteract(AncapWorldInteractEvent e) {  
	        if (e.isIntercepted()) {  
	            return;  
		    }  
	        AncapStatesPlayer player = new AncapStatesPlayer(e.getPlayer().getName());  
		    Location loc = e.getLocation();  
		    if (!player.canInteract(loc)) {  
		        e.setCancelled(true);  
	        }  
        }  
    }

Вообще фреймворк достаточно мощный, но мне щас лень описывать все плюшки его, можете почитать исходный код
