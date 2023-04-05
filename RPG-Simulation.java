package asg6sp23;

public class Character {
	
	private String name;
	private int health;
	private int mana;  // Initialized private variables
	
	public Character(String name, int health, int mana) {
		this.name = name;
		this.health = health;
		this.mana = mana;  // Constructor with fields 
		
	}
	
	// Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	// Getters
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void attackCommand(Character target) {
		System.out.println(name + " deals 6 damage to " + target.getName() + ".");
        target.setHealth(target.getHealth() - 6);
	}  // Attack method which takes health from a given target
	
	public String toString() {
        return "Character " + name + ": Health - " + health + " || Mana - " + mana;
    }  // Displays the information of the character
	
}


package asg6sp23;

public class Warrior extends Character implements WarriorAttack{
	
	private int strength;  // private variable added
	
	public Warrior(String name, int health, int mana, int strength) {
		super(name, health, mana);
		this.strength = strength;  // Warrior contructor that is the same as Character but adds strength
	}
	
	// Setter
    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    // Getter
    public int getStrength() {
        return strength;
    }
    
    public void swordAttack(Character target) {
    	
    	// Prompts the method to decrease targets health using dmg to measure the damage
        int dmg = getStrength();
        target.setHealth(target.getHealth() - dmg);
        System.out.println(getName() + " slashes " + target.getName() + " for " + dmg + " damage."); 
        
        // Reduce the strength by 8 after attacking
        setStrength(getStrength() - 8);
        System.out.println(getName() + " lost 8 strength.");
    }
    
    public String toString() {
        return "Warrior " + super.toString() + "|| Strength - " + strength;
    }  // Displays the information of the character

}

package asg6sp23;

public class Mage extends Character implements MageAttack{
	
	private int intelligence; // private variable added
    
    public Mage(String name, int health, int mana, int intelligence) {
        super(name, health, mana);
        this.intelligence = intelligence;  // Mage contructor that is the same as Character but adds intelligence
    }
    
    // Setter
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    // Getter
    public int getIntelligence() {
        return intelligence;
    }
    
    public void fireballSpell(Character target) {
    	
    	// Prompts the method to decrease targets health and uses dmg to measure deduction to health
        int dmg = getIntelligence();
        target.setHealth(target.getHealth() - dmg);
        System.out.println(getName() + " casts a spell at " + target.getName() + ", dealing " + dmg + " damage.");
        
        // Reduce mana by 16 after casting spell
        setMana(getMana() - 16);
        System.out.println(getName() + " lost 16 mana.");
    }
    
    // toString method
    public String toString() {
        return "Mage " + super.toString() + " || Intelligence - " + intelligence;
    }  // Displays the information of the character

}

package asg6sp23;

public interface WarriorAttack {
	public void swordAttack(Character target);
	// Interface for the swordAttack from the Warrior class
}

package asg6sp23;

public interface MageAttack {
    public void fireballSpell(Character target);
    // Interface for the fireballSpell from Mage
}

package asg6sp23;

public class Druid extends Warrior implements WarriorAttack {
	
	private int wisdom; // Private variable added
	
	public Druid(String name, int health, int mana, int strength, int wisdom) {
		super(name, health, mana, strength);
        this.wisdom = wisdom;  // Mage contructor that is the same as Character but adds wisdom
	}
	
	// Setter
	public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    
	// Getter
    public int getWisdom() {
        return wisdom;
    }
    
    public void heal(Character target) {
        
        // Simple heal - increases target's health by druid's wisdom
        int amount = getWisdom();
        target.setHealth(target.getHealth() + amount);
        System.out.println(getName() + " heals " + target.getName() + " for " + amount + " health.");
        
        // Reduce druid's wisdom by 5 after healing
        setWisdom(getWisdom() - 5);
        System.out.println(getName() + " lost 5 wisdom.");
    }
    
    @Override
    public void swordAttack(Character target) {
               
    	// Prompts the method to decrease targets health using dmg to measure the damage
        int dmg = getStrength();
        target.setHealth(target.getHealth() - dmg);
        System.out.println(getName() + " slashes " + target.getName() + " for " + dmg + " damage."); 
        
        // Reduce the strength by 8 after attacking
        setStrength(getStrength() - 8);
        System.out.println(getName() + " lost 8 strength.");
    }
    
    public String toString() {
    	return "Druid " + super.toString() + " || Wisdom - " + wisdom;
    }  // Displays the information of the character
    

}

package asg6sp23Test;
import java.util.Random;
import asg6sp23.Character;
import asg6sp23.Warrior;
import asg6sp23.Mage;
import asg6sp23.Druid;


public class GameDriver {
	public static void main(String[] args) {
		
        Random rand = new Random();  // Allows for a random number generator 
        
     // Creates all of the characters respectively
        Warrior warrior = new Warrior("Guts", rand.nextInt(75) + 1, rand.nextInt(50) + 1, rand.nextInt(75) + 1);
        Mage mage = new Mage("Harry Potter", rand.nextInt(50) + 1, rand.nextInt(100) + 1, rand.nextInt(75) + 1);
        Druid druid = new Druid("Malfurion", rand.nextInt(75) + 1, rand.nextInt(50) + 1, rand.nextInt(50) + 1, rand.nextInt(50) + 1);
        Character skeleton = new Character("Dry Bones", rand.nextInt(25) + 1, rand.nextInt(5) + 1);
        Character zombie = new Character("Walker", rand.nextInt(30) + 1, rand.nextInt(10) + 1);
        Character goblin = new Character("Griphook", rand.nextInt(40) + 1, rand.nextInt(35) + 1);
        
        // Prints all of the stats before any actions
        System.out.println(warrior.toString());
        System.out.println(mage.toString());
        System.out.println(druid.toString());
        System.out.println(skeleton.toString());
        System.out.println(zombie.toString());
        System.out.println(goblin.toString());
        
        System.out.println("\n");
        
        // Actions
        warrior.swordAttack(skeleton);
        mage.fireballSpell(zombie);
        goblin.attackCommand(warrior);
        druid.heal(warrior);
        druid.swordAttack(goblin);
        
        System.out.println("\n");
        
        // Print out the stats after actions
        System.out.println(warrior.toString());
        System.out.println(mage.toString());
        System.out.println(druid.toString());
        System.out.println(skeleton.toString());
        System.out.println(zombie.toString());
        System.out.println(goblin.toString());
        
	}
}
	
