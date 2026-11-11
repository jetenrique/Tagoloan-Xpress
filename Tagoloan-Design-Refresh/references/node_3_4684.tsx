const assetPathPrefix = "https://www.figma.com/api/mcp/asset/94339c21-8f20-49d8-b3b5-c7c9689cfd8f";
const imgRiderPhoto = `${assetPathPrefix}/7d6e3.png`;
const imgReceiptPhoto = `${assetPathPrefix}/692f9.png`;
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconShare = `${assetPathPrefix}/e8120.svg`;
const imgIconCheck = `${assetPathPrefix}/dc71b.svg`;
const imgIconFood = `${assetPathPrefix}/af0d8.svg`;
const imgDot = `${assetPathPrefix}/7aa0e.svg`;
const imgDot1 = `${assetPathPrefix}/9b200.svg`;
const imgIconStar = `${assetPathPrefix}/9aab1.svg`;

export default function CustomerViewReceipt() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:4684" data-name="customer view receipt">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="121:152" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="121:153" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="121:154" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="121:155">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="121:156" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="121:157" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="121:159" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="121:161" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="121:163" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="121:164" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="121:165" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="121:167" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="121:168">
              Receipt
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="121:169">
              #TGX-8921
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="121:170" data-name="Action button">
            <div className="relative shrink-0 size-[18px]" data-node-id="121:171" data-name="icon/share">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconShare} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-col gap-[16px] items-start overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="121:177" data-name="Body">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[6px] items-center overflow-clip px-[16px] py-[24px] relative rounded-[16px] shrink-0 w-full" data-node-id="121:178" data-name="Summary">
            <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[24px] shrink-0 size-[48px]" data-node-id="121:179" data-name="Container">
              <div className="relative shrink-0 size-[24px]" data-node-id="121:180" data-name="icon/check">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
              </div>
            </div>
            <div className="h-[6px] relative shrink-0 w-px" data-node-id="121:182" data-name="Container" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#18181f] text-[32px] whitespace-nowrap" data-node-id="121:183">
              ₱255.00
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="121:184">
              Paid in cash · Sept 17, 2026, 11:30 AM
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[14px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="121:185" data-name="Order">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="121:186">
              Order
            </p>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="121:187" data-name="Container">
              <div className="bg-[#fff7e0] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[40px]" data-node-id="121:188" data-name="Container">
                <div className="relative shrink-0 size-[20px]" data-node-id="121:189" data-name="icon/food">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFood} />
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="121:193" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="121:194">
                  Minute Burger (x2)
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="121:195">{`Buy & deliver`}</p>
              </div>
            </div>
            <div className="bg-[#fbf9f1] content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="121:196" data-name="Route">
              <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="121:197" data-name="Container">
                <div className="relative shrink-0 size-[8px]" data-node-id="121:198" data-name="dot">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgDot} />
                </div>
                <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="121:199" data-name="Container">
                  <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="121:200">
                    Pickup
                  </p>
                  <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="121:201">
                    Minute Burger, Poblacion
                  </p>
                </div>
              </div>
              <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="121:202" data-name="Container">
                <div className="relative shrink-0 size-[8px]" data-node-id="121:203" data-name="dot">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgDot1} />
                </div>
                <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="121:204" data-name="Container">
                  <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="121:205">
                    Drop-off
                  </p>
                  <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="121:206">
                    Zone 3, Mohon, Tagoloan
                  </p>
                </div>
              </div>
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="121:207">
              2.0 km · Delivered in 18 mins
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="121:208" data-name="Payment">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="121:209">
              Payment
            </p>
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="121:210" data-name="Row – Store receipt">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="121:211">
                Store receipt
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="121:212">
                ₱195.00
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="121:213" data-name="Row – Delivery fee">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="121:214">
                Delivery fee
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="121:215">
                ₱60.00
              </p>
            </div>
            <div className="bg-[#ece8df] h-px relative shrink-0 w-full" data-node-id="121:216" data-name="Divider" />
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[#18181f] w-full" data-node-id="121:217" data-name="Row – Total paid">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold min-w-px relative text-[14px]" data-node-id="121:218">
                Total paid
              </p>
              <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[18px] whitespace-nowrap" data-node-id="121:219">
                ₱255.00
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex font-['Plus_Jakarta_Sans:Regular'] font-normal gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="121:220" data-name="Row – Cash given">
              <p className="flex-[1_0_0] min-w-px relative" data-node-id="121:221">
                Cash given
              </p>
              <p className="relative shrink-0 whitespace-nowrap" data-node-id="121:222">
                ₱500.00
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex font-['Plus_Jakarta_Sans:Regular'] font-normal gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="121:223" data-name="Row – Change">
              <p className="flex-[1_0_0] min-w-px relative" data-node-id="121:224">
                Change
              </p>
              <p className="relative shrink-0 whitespace-nowrap" data-node-id="121:225">
                ₱245.00
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="121:226" data-name="Rider">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="121:227">
              Rider
            </p>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="121:228" data-name="Container">
              <div className="relative shrink-0 size-[44px]" data-node-id="121:229" data-name="Rider photo">
                <img alt="" className="absolute block inset-0 max-w-none size-full" height="44" src={imgRiderPhoto} width="44" />
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="121:230" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="121:231">
                  Juan Dela Cruz
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="121:232">
                  Honda Wave 110 · ABC 1234
                </p>
              </div>
              <div className="bg-[#fff7e0] content-stretch flex gap-[4px] items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="121:233" data-name="Container">
                <div className="relative shrink-0 size-[12px]" data-node-id="121:234" data-name="icon/star">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="121:236">
                  4.9
                </p>
              </div>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="121:237" data-name="Store receipt photo">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="121:238">
              Store receipt photo
            </p>
            <div className="h-[180px] relative rounded-[12px] shrink-0 w-full" data-node-id="121:239" data-name="Receipt photo">
              <img alt="" className="absolute inset-0 max-w-none object-cover pointer-events-none rounded-[12px] size-full" src={imgReceiptPhoto} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="121:240">
              Taken by the rider at checkout
            </p>
          </div>
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="121:241" data-name="Button – Close receipt">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="121:242">
              Close receipt
            </p>
          </a>
          <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#a3a3ab] text-[11px] text-center w-[min-content]" data-node-id="121:244">
            Ref. TGX-2026-8921
          </p>
          <div className="h-[16px] relative shrink-0 w-px" data-node-id="121:245" data-name="Container" />
        </div>
      </div>
    </div>
  );
}
