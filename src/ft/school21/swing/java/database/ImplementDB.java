package ft.school21.swing.java.database;

import ft.school21.swing.java.model.GameActions;
import ft.school21.swing.java.model.PlayArmor.DarkArmor;
import ft.school21.swing.java.model.PlayArmor.DragonScaleArmor;
import ft.school21.swing.java.model.PlayArmor.RagsArmor;
import ft.school21.swing.java.model.PlayArmor.WolfArmor;
import ft.school21.swing.java.model.PlayHelm.DarkHelm;
import ft.school21.swing.java.model.PlayHelm.DragonScaleHelm;
import ft.school21.swing.java.model.PlayHelm.RagsHelm;
import ft.school21.swing.java.model.PlayHelm.WolfHelm;
import ft.school21.swing.java.model.PlayRaces.*;
import ft.school21.swing.java.model.Repositor.Classes;
import ft.school21.swing.java.model.Weapons.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ImplementDB {

    //TODO: close factory in finally
    private static SessionFactory factory;
    private static ImplementDB implementDB;
    private ImplementDB()
    {

    }

    public static ImplementDB getImplementDB() {
        if (implementDB == null) {
            implementDB = new ImplementDB();
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Heroes.class)
                    .buildSessionFactory();
        }
        return implementDB;
    }

    public SessionFactory getFactory()
    {
        return factory;
    }

    public void AddHeroDB(Heroes heroes)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(heroes);
        session.getTransaction().commit();
    }

    public Heroes getHeroDB(Long id)
    {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Heroes heroes = session.get(Heroes.class, id);
        session.getTransaction().commit();
        return heroes;
    }

    public ArrayList<GameActions> getAllHeroesDB()
    {
        ArrayList<GameActions> players = new ArrayList<GameActions>();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Heroes> list = session.createQuery("from Heroes").getResultList();
            session.getTransaction().commit();
            //TODO: заполнить поля сущности GameActions из бд;
            for (int i = 0; i < list.size(); i++) {
                GameActions gameActions = new GameActions();
                System.out.println(list.get(i));
                if (!list.get(i).getName().isEmpty())
                    gameActions.setName(list.get(i).getName());
                if (list.get(i).getLevel() >= 0)
                    gameActions.setLevel(list.get(i).getLevel());
                if (list.get(i).getAttack() >= 0)
                    gameActions.setAttack(list.get(i).getAttack());
                if (!list.get(i).getClas().isEmpty()) {
                    switch (list.get(i).getClas().toLowerCase()) {
                        case "warrior":
                            gameActions.setPlayClasses(Classes.Warrior);
                            break;
                        case " wizard":
                            gameActions.setPlayClasses(Classes.Wizard);
                            break;
                        case "berserk":
                            gameActions.setPlayClasses(Classes.Berserk);
                            break;
                        case "necromancer":
                            gameActions.setPlayClasses(Classes.Necromancer);
                            break;
                    }
                }
                if (!list.get(i).getRace().isEmpty()) {
                    switch (list.get(i).getRace().toLowerCase()) {
                        case "darkelf":
                            gameActions.setPlayRaces(new DarkElf());
                            break;
                        case "dwarf":
                            gameActions.setPlayRaces(new Dwarf());
                            break;
                        case "elf":
                            gameActions.setPlayRaces(new Elf());
                            break;
                        case "human":
                            gameActions.setPlayRaces(new Human());
                            break;
                        case "orc":
                            gameActions.setPlayRaces(new Orc());
                            break;
                    }

                }
                if (!list.get(i).getArmor().isEmpty()) {
                    switch (list.get(i).getArmor().toLowerCase()) {
                        case "dark":
                            gameActions.setPlayArmor(new DarkArmor());
                            break;
                        case "dragonscale":
                            gameActions.setPlayArmor(new DragonScaleArmor());
                            break;
                        case "rags":
                            gameActions.setPlayArmor(new RagsArmor());
                        case "wolf":
                            gameActions.setPlayArmor(new WolfArmor());
                    }
                }
                if (!list.get(i).getHelm().isEmpty()) {
                    switch (list.get(i).getHelm().toLowerCase()) {
                        case "dark":
                            gameActions.setPlayHelm(new DarkHelm());
                            break;
                        case "dragonscale":
                            gameActions.setPlayHelm(new DragonScaleHelm());
                            break;
                        case "rags":
                            gameActions.setPlayHelm(new RagsHelm());
                            break;
                        case "wolf":
                            gameActions.setPlayHelm(new WolfHelm());
                            break;
                    }
                }
                if (!list.get(i).getWeapon().isEmpty()) {
                    switch (list.get(i).getWeapon().toLowerCase()) {
                        case "bow":
                            gameActions.setPlayWeapon(new Bow());
                            break;
                        case "mace":
                            gameActions.setPlayWeapon(new Mace());
                            break;
                        case "magicwand":
                            gameActions.setPlayWeapon(new MagicWand());
                            break;
                        case "staff":
                            gameActions.setPlayWeapon(new Staff());
                            break;
                        case "sword":
                            gameActions.setPlayWeapon(new Sword());
                            break;
                    }
                }
                gameActions.setId(list.get(i).getId());
                players.add(i, gameActions);
            }
        }
        finally {
//            factory.close();
        }
        return players;
    }

    public void DeleteHero(Long id)
    {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Heroes hero = session.get(Heroes.class, id);
            session.delete(hero);
            session.getTransaction().commit();
        }
        finally {
//            factory.close();
        }
    }
}
