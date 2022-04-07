
# AncapLibrary
Обширный фреймворк для баккит-разработки, определяющий объектно ориентированный стиль плагина.

На данный момент AncapLibrary состоит из следующих модулей:
- AncapPlugin - расширение BukkitPluginApi, "из коробки" имплементирующее bstats, а также существенно упрощающее процесс регистрации слушателей ивентов и команд
- AncapEvents - удобный лаконичный набор ивентов, например AncapWorldInteractEvent вместо двух десятков подобных нативных от Bukkit
- AncapCommandAPI - полностью переработанное BukkitCommandAPI, написанное в ООП-стиле и предназначенное для создания высоконагруженных команд
- AncapConfiguration - удобный способ для управления файлами конфигурации плагина
- AncapEconomy - API для работы с валютами, кошельками, балансами, независимое от количества и типа валют (да и от майнкрафта вообще, планирую в будущем выделить в отдельную библиотеку для AncapLibrary).
- AncapLocation для работы с локациями игроков, опять же в угоду ООП-стилю
- AncapPlayerAPI, предоставляющее универсальное, невероятно удобное, расширяемое API для работы с игроками сервера (15 классов, 15 интерфейсов, интеграция с базой данных и расширяемым PlayerMap "из коробки"), находится в разработке
- AncapPacketAPI - API для отправки сообщений, титлов, звуков игрокам (реализовано в ООП-стиле, в отличии от того что представляется Bukkit'ом)
- AncapHeartbeat - ивент, бросаемый каждую секунду (работает на BukkitSheduler)
- AncapTimerAPI для создания ивентов, вызываемых по таймеру (работает на AncapHeartbeat)

А также из более мелких:
- StringParser (написано для записи балансов в конфиг, в основном, но можно использовать и для других целей)
- HexableString (для проверки, является ли строка шестнадцатиричным числом)
- SMassiveAPI (крайне устаревший модуль, написан мной более года назад и сохранён для возможности переезда со API-VERSION:2 на API-VERSION:3 для записей в базах данных, будет удалён в SNAPSHOT.18)

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
			<version>LATEST</version>  
			<scope>provided</scope>  
		</dependency>  
		<dependency>
			<groupId>ru.pukpukov</groupId>  
			<artifactId>AncapDatabase</artifactId>  
			<version>LATEST</version>  
			<scope>provided</scope>  
		</dependency>
     </dependencies>

## Использование

### Объявление мейн-класса плагина

    public class AncapAFB extends AncapPlugin {
    	@Override
	public void onEnable() {
		super.onEnable();
		// код
	}
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

Вообще фреймворк достаточно мощный, но мне щас лень описывать подробно все плюшки его, можете почитать исходный код
