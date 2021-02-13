class Battlefield :Battle{
    companion object{
        val listhero = mutableListOf<Hero>()
    }
    override fun attack(attacker: String, defender: String) {
        var attackerHero :Hero? = null
        var defenderHero :Hero? = null
        for(hero in listhero){
            if(hero.name == attacker){
                attackerHero = hero
            }
            else if(hero.name == defender){
                defenderHero = hero
            }
        }
        val attack = attackerHero?.baseAttack
        defenderHero?.HP = defenderHero?.HP?.minus(attack?:0)
    }


}