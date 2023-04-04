import org.apache.spark.sql.{SaveMode, SparkSession}

import scala.Console.println

object program1 {

  def main(args:Array[String]):Unit={

    val spark=SparkSession.builder()
      .appName("count")
      .master("local[3]")
      .getOrCreate()

    val countDf=spark.read
      .format("csv")
      .option("Header","True")
      .option("mode","FAILFAST")
      .load("Program1")
       countDf.show(false)
       countDf.count()
       println(countDf.count())

    countDf.write
      .format("json")
      .mode(SaveMode.Overwrite)
      .option("path","Program1/output")
      .save()


  }
}


