package com.poomgames.data.local.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poomgames.domain.entities.Fact

@Entity
class DbFact(
    @PrimaryKey
    var hintText: String
) {

    fun mapToHint(dbFact: DbFact): Fact {
        return Fact(dbFact.hintText)
    }
}