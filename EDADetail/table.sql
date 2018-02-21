create table emergencyeda.location(
	localId int(5) auto_increment not null,
	localName varchar(255) not null,
	subprovinceName varchar(255) not null,
	primary key(localId)
);

create table emergencyeda.local_user(
	userId int(5) auto_increment not null,
	localId int(5) not null,
	primary key (userId),
	foreign key (localId) references emergencyeda.location(localId)
);

create table emergencyeda.category_list(
	catId int(5) auto_increment not null,
	catName varchar(255) not null,
	catDesp long varchar not null,
	primary key (catId)
);

create table emergencyeda.disaster_info(
	disasterId int(5) auto_increment not null,
	disasterName varchar(255) not null,
	disasterCatId int(5) not null,
	desp_disaster varchar(255) not null,
	createDate date,
	primary key (disasterId),
	foreign key (disasterId) references emergencyeda.category_list(catId)
);

create table emergencyeda.list_alerts(
	alertId int(5) auto_increment not null,
	localId int(5) not null,
	disasterId int(5) not null,
	alertDate date,
	alertDisasterDate date,
	primary key (alertId),
	foreign key (localId) references emergencyeda.location(localId),
	foreign key (disasterId) references emergencyeda.disaster_info(disasterId) 
);

insert into emergencyeda.location(localName, subprovinceName) 
	values(
		'bangkok',
		'thrung-kru'
		);
insert into emergencyeda.location(localName, subprovinceName) 
	values(
		'Chonburi',
		'Banbung'
		);
insert into emergencyeda.category_list(catName, catDesp) values('Flood', 'A flood is an overflow of water that submerges land that is usually dry.');
insert into emergencyeda.category_list(catName, catDesp) values('Tsunami', 'is a series of waves in a water body caused by the displacement of a large volume of water');
insert into emergencyeda.disaster_info(disasterName, disasterCatId, desp_disaster, createDate) 
	values('4 Dead in Rio After Storm Dumps 123mm of Rain in 1 Hour'
		, 1
		, 'A storm that hit Rio de Janeiro, Brazil, between 14 and 15 February 2018 caused severe wind damage and flooding across the city.'
		, STR_TO_DATE('2018-02-22', '%Y-%m-%d'));
insert into emergencyeda.disaster_info(disasterName, disasterCatId, desp_disaster, createDate) 
	values('East coast tsunami warning was just a test, says National Weather Service'
		, 2
		, 'The National Weather Service issued a tsunami warning for Miami, Charleston and elsewhere at around 8.30am. The weather app Accuweather picked up on the message and sent out a mobile alert to subscribers.'
		, STR_TO_DATE('2018-02-22', '%Y-%m-%d'));
insert into emergencyeda.list_alerts(localId, disasterId, alertDate, alertDisasterDate) 
values(1, 1,
	STR_TO_DATE('2018-02-19', '%Y-%m-%d'),
	STR_TO_DATE('2018-02-19', '%Y-%m-%d'));
insert into emergencyeda.list_alerts(localId, disasterId, alertDate, alertDisasterDate) 
values(1, 2,
	STR_TO_DATE('2018-02-20', '%Y-%m-%d'),
	STR_TO_DATE('2018-02-20', '%Y-%m-%d'));




drop table emergencyeda.list_alerts;
drop table emergencyeda.local_user;
drop table emergencyeda.disaster_info;
drop table emergencyeda.category_list;
drop table emergencyeda.location;