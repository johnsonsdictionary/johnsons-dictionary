# johnsons-dictionary

## A note on omissions/discrepancies

Johnson’s dictionary, by default, doesn’t include preterites/past-participles (eg. walked), present participles (eg. walking) for *regular* verbs,  or any third-person-singular present tenses (eg. walks)

It does appear for the most part to include the preterites/past-participles for *irregular* verbs.

There are, however, some preterites/past-participles for irregular verbs that are missing - these are listed within the omitted-preterites-and-participles project.

The **JohnsonsDictionaryWords.getClassifiedWords** method (from the dictionary-words project) returns all the words that have been classified into different categories from the dictionary (this includes the irregular verb preterites/past-participles), and can optionally include those that have been omitted.

When we compare this list (including omissions) with the set of words from the dictionary (including omissions) ( **JohnsonsDictionary.getDictionaryWords method** from the dictionary-core project),  there still remain a couple of discrepancies.

*   Entries from classified words that don’t have entries in the dictionary:

    **[borne, sewn]**

    Borne is mentioned in a few other entries in their references, and 		OED says that spelling of borne/born were interchangeable - but 		despite this, borne doesn’t have an entry

    Sewn is never mentioned - but does this mean that sew is regular, 		and we should have sewed as the past participle ?  This is not clear.

*   Entries from the dictionary, which don’t appear in the list of classified words:

    **[dying, lying, owing, passed, vowed]**

    Owing and vowed are in data, but not searchable

    Dying, lying and passed have their own entries,  even though the 		corresponding verbs (die, lie) are regular.   For dying and lying this could be to emphasis the changing of the ie -> y,  but why for passed ?

## Questions:

* Why are **“firstly”** and **“ninthly”** not present, but “secondly”, “thirdly”, “fourthly”, “fifthly”, “sixthly”, “seventhly”, “eighthly” and “tenthly” all present
* Why are there some entries in the dictionary ( **"owing"** and **"vowed"**) not appearing in the search at johnsonsdictionaryonline.com, but are listed on the browse by letter page?
* Why do the following **regular** verb conjugations have their own entries:  **"dying"**, **"lying"** and **"passed"**.
* Why don’t the preterites/past-participles for the **irregular** verbs that are listed in the omitted-preterites-and-participles project have their own entries ?
