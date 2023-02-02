package com.poomgames.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poomgames.data.local.enteties.DbFact
import com.poomgames.domain.entities.Fact

@Dao
interface FactDao {

    @Query("SELECT * FROM DbFact")
    suspend fun getAllFacts(): List<DbFact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFacts(fact: DbFact)
}